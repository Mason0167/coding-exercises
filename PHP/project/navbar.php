<header>
    <form method="post">
        <input type="submit" name="theme" value="White">
        <input type="submit" name="theme" value="Black">
    </form>

    <h1>Hi!
        <?php
        if(isset($_SESSION['userName'])){
            echo $_SESSION['userName'] . "<br>";
        }
        ?>
        Welcome to the Voting App</h1>

    <nav>
        <ul id="dashboard_navbar" >
            <li class="items"><a href="dashboard.php">Dashboard</a></li>
            <li class="items"><a href="topic_list.php">Topics</a></li>
            <li class="items"><a href="profile.php">Profile</a></li>
            <li class="items"><a href="logout.php">Logout</a></li>
        </ul>
    </nav>
</header><br>

