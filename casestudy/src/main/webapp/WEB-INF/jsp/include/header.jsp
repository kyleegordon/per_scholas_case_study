<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="../../../pub/css/styles.css">
    <!-- adds font Ubuntu -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;700&display=swap" rel="stylesheet">
    <!-- links to font awesome for icons -->
    <script src="https://kit.fontawesome.com/91d2a50ff4.js" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar">
    <div class="navbar__container">
        <a href="/index" id="navbar__logo"><i class="fas fa-dice-d20"></i>NameHere</a>
        <div class="navbar__toggle" id="mobile-menu">
            <!-- These are the 3 bars for the mobile menu icon -->
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </div>
        <ul class="navbar__menu">
            <li class="navbar__item">
                <a href="/index" class="navbar__links">Home</a>
            </li>
            <li class="navbar__item">
                <a href="/about" class="navbar__links">About</a>
            </li>
            <li class="navbar__item">
                <a href="/assessment" class="navbar__links">Assessment</a>
            </li>
            <li class="navbar__item">
                <a href="/login/login" class="navbar__links">Login</a>
            </li>
            <li class="navbar__btn">
                <a href="/signup" class="button">Sign Up</a>
            </li>
        </ul>
    </div>
</nav>