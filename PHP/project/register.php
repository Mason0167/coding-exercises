<script>
    function checkInput(){
        const userName = document.getElementById("userName")
        const userPassword = document.getElementById("userPassword")
        const userEmail = document.getElementById("userEmail")

        if(userName.value.trim() === "" || userPassword.value.trim() === "" || userEmail.value.trim() === ""){
            alert("Username or password or email is empty.");
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

if(isset($_POST['registerBtn']) && $_SERVER['REQUEST_METHOD'] === 'POST'){
    $userName = $_POST['userName'];
    $userPassword = $_POST['userPassword'];
    $userEmail = $_POST['userEmail'];

    $pdo = require 'connect_db.php';
    $registerUser = new User($pdo);
    $registerUser -> registerUser($userName, $userEmail, $userPassword);
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Voting App - Register</title>
    <link rel="stylesheet" href="assets/css/main.css">
</head>

<body>
<div id="register_div">
    <h1>Register</h1>

    <form id="registerForm" method="POST" onsubmit="return checkInput()">
        <p>
            <?php
            if (isset($_SESSION['registerSuccess'])) {
                echo "<span class='errorMsg'>" . $_SESSION['registerSuccess'] . "</span>" . "<a href='login.php'>" . "  Login" . "</a>";
                unset($_SESSION['registerSuccess']);
            }
            ?>
        </p>

        <label>
            Username: <br>
            <input type="text" id="userName" name="userName">
        </label>

        <label>Password: <br>
            <input type="password" id="userPassword" name="userPassword">
        </label>

        <label>Email: <br>
            <input type="email" id="userEmail" name="userEmail">
        </label><br>

        <p>
            <?php
            // Display the error if the username exists
            if (isset($_SESSION['registerError'])) {
                echo "<p class='errorMsg'>" . $_SESSION['registerError'] . "</p>";
                unset($_SESSION['registerError']);
            }
            ?>
        </p>
        <button type="submit" name="registerBtn">REGISTER</button><br><br>
    </form>

</div>
<footer id="sourceCode">
    <?php show_source(__FILE__);?>
</footer>
</body>
</html>