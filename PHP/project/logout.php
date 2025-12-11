<?php
session_start();
session_destroy();
unset($_SESSION['theme']);
header("location: login.php");

