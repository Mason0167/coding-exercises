<script>
    function checkInput(){
        const topicTitle = document.getElementById("topicTitle")
        const topicDescription = document.getElementById("topicDescription")

        if(topicTitle.value.trim() === "" || topicDescription.value.trim() === ""){
            alert("Title or Description is empty.");
            return false;
            // Stop here, do not submit
        }else{
            return true;
        }
    }
</script>

<?php
session_start();
require_once 'classes.php';

if(isset($_POST['createBtn']) && $_SERVER['REQUEST_METHOD'] === 'POST'){
    $topicTitle = $_POST['topicTitle'];
    $topicDescription = $_POST['topicDescription'];

    $userID = $_SESSION['user_id'];

    $pdo = require 'connect_db.php';
    $createTopic = new Topic($pdo);
    $createTopic -> createTopic($userID, $topicTitle, $topicDescription);
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Voting App - Dashboard/Create Topic</title>
    <link rel="stylesheet" href="assets/css/dashboardMain.css">
</head>
<body>
<?php require_once __DIR__ . '/navbar.php'; ?>
<div id="dashboard_div">
    <?php
    if (isset($_SESSION['topicCreated'])) {
        echo "<span class='errorMsg'>" . $_SESSION['topicCreated'] . "</span>" . "<a href='topic_list.php'>" . "  Topic List" . "</a>";
        unset($_SESSION['topicCreated']);
    }
    ?>
    <h1>Create a Topic</h1>
    <form id="topicForm" method="POST" onsubmit="return checkInput()">
        <?php
        if (isset($_SESSION['topicError'])) {
            echo "<span class='errorMsg'>" . $_SESSION['topicError'] . "</span>" . "<a href='login.php'>" . "  Login" . "</a>";
            unset($_SESSION['topicError']);
        }
        ?>

        <label>
            Title: <br>
            <input type="text" id="topicTitle" name="topicTitle">
        </label><br><br>

        <label>Description: <br>
        <textarea type="text" id="topicDescription" name="topicDescription"></textarea>
        </label><br><br>

        <button type="submit" name="createBtn">CREATE</button<br><br>
    </form>
</div>
</body>

</html>

<?php show_source(__FILE__);?>
