<?php
session_start();
$pdo = require 'connect_db.php';
require_once 'classes.php';

$userName = $_SESSION["userName"];

$voteTypeSumArrays = getUserVotingHistory($userName)['voteTypeSumArr'];;
$voteNum = getUserVotingHistory($userName)['totalVotes'];
$topicNum = getUserVotingHistory($userName)['totalTopics'];

$theme = getCookie('theme') ?? 'white';
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Voting App - Profile</title>
    <link rel="stylesheet" href="assets/css/dashboardMain.css">
    <style>
        body{
            background-color: <?php echo htmlspecialchars($theme);?>;
        }
    </style>
</head>

<body>
<?php require_once __DIR__ . '/navbar.php'; ?>
<div>
    <p>
        Total Topics Created:
        <?php echo $topicNum; ?>
    </p>
    <p>
        Total Votes Cast:
        <?php echo $voteNum; ?>
    </p>
</div><br>
<?php if(count($voteTypeSumArrays) > 0): ?>
    <?php foreach ($voteTypeSumArrays as $arr) : ?>
        <div>
            <h2>The topic you have voted: </h2>
            <p>
                Title: <br>
                <?php echo htmlspecialchars($arr['topicTitle']); ?>
            </p>
            <p>
                Description: <br>
                <?php echo htmlspecialchars($arr['topicDescription']); ?>
            </p>
            <p>
                Vote Type: <br>
                <?php echo htmlspecialchars($arr['voteType']); ?>
            </p>
        </div><br>
    <?php endforeach; ?>

<?php else: ?>
    <p>No topics voted</p>
<?php endif; ?>
</body>
</html>

<?php show_source(__FILE__);?>