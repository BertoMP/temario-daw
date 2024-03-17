<?php
const DB_HOST = 'localhost';
const DB_PORT = '3308';
const DB_NAME = 'BIBLIOTECA';
const DB_USER = 'root';
const DB_PASS = '';

const DEFAULT_CONTROLLER = 'BookController';
const DEFAULT_ACTION = 'list';
const DEFAULT_PARAMS = array();

const APP_DIRECTORY = 'http://localhost/MVC-Simple/';
const INDEX_URL = APP_DIRECTORY . 'index.php';
const CSS_URL = APP_DIRECTORY . 'css/style.css';
const CONTROLLERs_URL = [
    'books' => INDEX_URL . '/BookController/',
    'users' => INDEX_URL . '/UserController/'
];
