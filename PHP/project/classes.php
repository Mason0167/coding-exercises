<?php
    class User
    {
        private $pdo;

        public function __construct($pdo)
        {
            $this->pdo = $pdo;
        }

        function registerUser($userName, $userEmail, $userPassword)
        {
            if (strlen($userPassword) < 9) {
                $_SESSION['registerError'] = "Password must have at least 9 characters";
                return false;
            }

            if(empty($userName) || empty($userEmail)) {
                $_SESSION['registerError'] = "Username or User Email can't be empty";
                return false;
            }

            if (!filter_var($userEmail, FILTER_VALIDATE_EMAIL)) {
                $_SESSION['registerError'] = "Invalid email format";
                return false;
            }

            try {
                $hashedPassword = password_hash($userPassword, PASSWORD_DEFAULT);

                $sql = "INSERT INTO Users (username, email, password) VALUES (:username, :email, :password)";
                $stmt = $this->pdo->prepare($sql);
                $stmt->bindParam(':username', $userName);
                $stmt->bindParam(':email', $userEmail);
                $stmt->bindParam(':password', $hashedPassword);
                $stmt->execute();

                $_SESSION['registerSuccess'] = "Register successfully.";
                return true;

            } catch (PDOException $e) {
                if ($e->errorInfo[1] == 1062) {
                    $_SESSION['registerError'] = "Username or Email already exists.";
                    return false;
                }
                $_SESSION['registerError'] = "Database error occurred.";
                return false;
            }
        }

        function authenticateUser($userName, $userPassword)
        {
            try {
                $sql = "SELECT * FROM Users WHERE username = :username";
                $stmt = $this->pdo->prepare($sql);
                $stmt->bindParam(':username', $userName);
                $stmt->execute();

                $user = $stmt->fetch(PDO::FETCH_ASSOC);
                if (!$user) {
                    $_SESSION['loginError'] = "Username is incorrect.";
                    return false;
                }

                if (!password_verify($userPassword, $user['password'])) {
                    $_SESSION['loginError'] = "Password is incorrect.";
                    return false;
                }

                $_SESSION['userName'] = $user['username'];
                $_SESSION['user_id'] = $user['id'];
                return true;

            } catch (PDOException $e) {
                $_SESSION['registerError'] = "Database error occurred.";
                return false;
            }
        }
    }


    class Topic
    {
        public $id;
        public $title;
        public $description;
        public $user_id;
        private $pdo;

        public function __construct($pdo)
        {
            $this->pdo = $pdo;
        }

        function createTopic($userID, $topicTitle, $topicDescription)
        {
            try {
                $sql = "INSERT INTO Topics (user_id, title, description) VALUES (:user_id, :title, :description)";
                $stmt = $this->pdo->prepare($sql);
                $stmt->bindParam(':user_id', $userID);
                $stmt->bindParam(':title', $topicTitle);
                $stmt->bindParam(':description', $topicDescription);
                $stmt->execute();

                $_SESSION['topicCreated'] = "Topic is created successfully.";
                return true;

            } catch (PDOException $e) {
                $_SESSION['topicError'] = "Something is wrong.";
                return false;
            }
        }

        function getTopics(){
            try {
                $sql = "SELECT * FROM Topics";
                $stmt = $this->pdo->prepare($sql);
                $stmt->execute();

                $rows = $stmt->fetchAll(PDO::FETCH_ASSOC);

                $topics = [];

                foreach ($rows as $row) {
                    $topic = new Topic($this->pdo);
                    $topic->id = $row['id'];
                    $topic->title = $row['title'];
                    $topic->description = $row['description'];
                    $topic->user_id = $row['user_id'];

                    $topics[] = $topic;
                }

                return $topics;
            } catch (PDOException $e) {
                return false;
            }
        }

        function getCreatedTopics($userID){
            try {
                $sql = "SELECT * FROM Topics WHERE user_id = :user_id";
                $stmt = $this->pdo->prepare($sql);
                $stmt->bindParam(':user_id', $userID);
                $stmt->execute();

                return $stmt->fetchAll(PDO::FETCH_ASSOC);

            } catch (PDOException $e) {
                return false;
            }
        }
    }


    class Vote{
        private $pdo;
        public function __construct($pdo){
            $this->pdo = $pdo;
        }

        function vote($userID, $topicID, $voteType){
            try{
                if($this->hasVoted($topicID, $userID)){
                    $_SESSION['voteError'] = "You have voted for this topic.";
                    return false;
                }

                $sql = "INSERT INTO Votes (user_id, topic_id, vote_type) VALUES (:user_id, :topic_id, :vote_type)";
                $stmt = $this->pdo->prepare($sql);
                $stmt->bindParam(':user_id', $userID);
                $stmt->bindParam(':topic_id', $topicID);
                $stmt->bindParam(':vote_type', $voteType);
                $stmt->execute();

                $_SESSION['voteSuccess'] = "You have voted for this topic.";
                return true;

            }catch (PDOException $e){
                return false;
            }
        }

        function hasVoted($topicID, $userID){
            try{
                $sql = "SELECT COUNT(*) FROM Votes WHERE user_id = :user_id AND topic_id = :topic_id";
                $stmt = $this->pdo->prepare($sql);
                $stmt->execute([
                    ':user_id' => $userID,
                    ':topic_id' => $topicID
                ]);

                return $stmt->fetchColumn() > 0;

            }catch (PDOException $e){
                return false;
            }
        }

        function getVoteResults($topicID){
            try{
                $sql = "SELECT vote_type, COUNT(*) AS vote_count FROM Votes WHERE topic_id = ? GROUP BY vote_type";
                $stmt = $this->pdo->prepare($sql);
                $stmt->execute([$topicID]);

                return $stmt->fetchAll(PDO::FETCH_ASSOC);

            }catch (PDOException $e){
                return [];
            }
        }

        function getUserVoteHistory($userID){
            try{
                $sql = "SELECT * FROM Votes WHERE user_id = :user_id";
                $stmt = $this->pdo->prepare($sql);
                $stmt->bindParam(':user_id', $userID);
                $stmt->execute();

                return $stmt->fetchAll(PDO::FETCH_ASSOC);

            }catch (PDOException $e){
                return false;
            }
        }
    }


    class Comment{
        private $pdo;
        public function __construct($pdo){
            $this->pdo = $pdo;
        }

        function addComment($userID, $topicID, $comment){
            try{
                $sql = "INSERT INTO Comments (user_id, topic_id, comment) VALUES (:user_id, :topic_id, :comment)";
                $stmt = $this->pdo->prepare($sql);
                $stmt->bindParam(':user_id', $userID);
                $stmt->bindParam(':topic_id', $topicID);
                $stmt->bindParam(':comment', $comment);
                $stmt->execute();

                return true;
            }catch (PDOException $e){
                return false;
            }
        }

        function getComments($topicID){
            try{
                $sql = "SELECT * FROM Comments WHERE topic_id = :topic_id";
                $stmt = $this->pdo->prepare($sql);
                $stmt->bindParam(':topic_id', $topicID);
                $stmt->execute();

                return $stmt->fetchAll(PDO::FETCH_ASSOC);

            }catch (PDOException $e){
                return [];
            }
        }
}

class TimeFormatter{
        public static function formatTimestamp($timestamp){
            $now = time();
            $difference = $now - $timestamp;

            // If less than an hour → minutes ago
            if ($difference < 3600) {
                $minutes = floor($difference / 60);
                return $minutes . " minutes ago";
            }

            // If less than a day → hours ago
            if ($difference < 86400) {
                $hours = floor($difference / 3600);
                return $hours . " hours ago";
            }

            // If less than 7 days → days ago
            if ($difference < 604800) {
                $days = floor($difference / 86400);
                return $days . " days ago";
            }

            // Otherwise → show formatted date
            return date("M d, Y", $timestamp);
        }
}

