<?php
session_start();
$pdo = require 'connect_db.php';
require 'classes.php';

$getTopics = new Topic($pdo);
$topics = $getTopics->getTopics();
$vote = new Vote($pdo);

if($_SERVER['REQUEST_METHOD'] === 'POST') {
    $userID = $_SESSION["user_id"];
    $topicID = $_POST["topicID"];

    if(isset($_POST['upBtn'])){
        $voteType = $_POST["upBtn"];
    }elseif(isset($_POST["downBtn"])){
        $voteType = $_POST["downBtn"];
    }

    $vote -> vote($userID, $topicID, $voteType);
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Voting App - Topic List/Vote</title>
    <link rel="stylesheet" href="assets/css/dashboardMain.css">
</head>

<body>
<?php require_once __DIR__ . '/navbar.php'; ?>
<div>
    <?php if(count($topics) > 0): ?>
        <table>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Vote</th>
            </tr>
            <?php
            if (isset($_SESSION['voteError'])) {
                echo "<p class='errorMsg'>" . $_SESSION['voteError'] . "</p>";
                unset($_SESSION['voteError']);
            }
            if (isset($_SESSION['voteSuccess'])) {
                echo "<p class='errorMsg'>" . $_SESSION['voteSuccess'] . "</p>"; unset($_SESSION['voteSuccess']);
            }
            ?>
            <?php foreach ($topics as $topic) : ?>
                <?php
                $topicID = $topic->id;

                // Get vote count for THIS topic only
                $results = $vote->getVoteResults($topicID);

                $upVotes = 0;
                $downVotes = 0;

                foreach ($results as $v){
                    if ($v['vote_type'] === 'up') {
                        $upVotes = $v['vote_count'];
                    } elseif ($v['vote_type'] === 'down') {
                        $downVotes = $v['vote_count'];
                    }
                }
                ?>
                <tr>
                    <td><?= htmlspecialchars($topic->title) ?></td>
                    <td><?= htmlspecialchars($topic->description) ?></td>
                    <td>
                        <form method="post">
                            <input type="hidden" name="topicID" value="<?= $topic->id ?>">
                            <button type="submit" name="upBtn" value='up'>
                                <?= $upVotes ?> Upvotes
                            </button>
                            <button type="submit" name="downBtn" value='down'>
                                <?= $downVotes ?> Downvotes
                            </button>
                        </form>
                    </td>
                </tr>

            <?php endforeach; ?>
        </table>

    <?php else: ?>
        <p>No topics created</p>
    <?php endif; ?>
</div>
</body>
</html>

<?php
// prints human-readable information about a variable, especially useful for arrays and objects.
//echo '<pre>';
//print_r(getTopics());
//echo '</pre>';
show_source(__FILE__);

?>