<?php
    // connect_db
    $config = require 'db.config.php';

    $dbHost = $config['app']['host'];
    $dbUser = $config['app']['username'];
    $dbPass = $config['app']['password'];
    $dbName = $config['app']['dbname'];

    $char_set = "utf8";

// Prepared statement connection
    $dsn = "mysql:host=$dbHost;dbname=$dbName;charset=$char_set";

    try {
        $pdo = new PDO($dsn, $dbUser, $dbPass);
        return $pdo;
    } catch (PDOException $e) {
        die("Error: " . $e->getMessage());
    }

