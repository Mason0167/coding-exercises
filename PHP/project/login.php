<script>
    function checkInput(){
        const userName = document.getElementById("userName")
        const userPassword = document.getElementById("userPassword")

        if(userName.value.trim() === "" || userPassword.value.trim() === ""){
            alert("Username or password is empty.");
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

if(isset($_POST['loginBtn']) && $_SERVER['REQUEST_METHOD'] === 'POST') {
    $userName = $_POST['userName'];
    $userPassword = $_POST['userPassword'];

    $pdo = require 'connect_db.php';
    $authenticateUser = new User($pdo);
    if($authenticateUser -> authenticateUser($userName, $userPassword)){
        header("location: dashboard.php");
        exit;
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Voting App - Login</title>
    <link rel="stylesheet" href="assets/css/main.css">
</head>

<body>
<div id="login_div">
    <h1>Log in!</h1>

    <form id="loginForm" method="POST" onsubmit="return checkInput()">
        <label>Username: <br>
            <input type="text" id="userName" name="userName">
        </label>

        <label>Password: <br>
            <input type="password" id="userPassword" name="userPassword">
        </label><br>

        <p>
            <?php
            if (isset($_SESSION['loginError'])) {
                echo "<p class='errorMsg'>" . $_SESSION['loginError'] . "</p>";
                unset($_SESSION['loginError']);
            }
            ?>
        </p>

        <button type="submit" name="loginBtn">LOGIN</button><br><br>
    </form>

</div>
<footer id="sourceCode">
    <?php show_source(__FILE__);?>
</footer>

</body>
</html>




