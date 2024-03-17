<?php

use App\Http\Controllers\PagesController;
use Illuminate\Support\Facades\Route;

Route::get('/', [PagesController::class, 'home']) -> name('home');
Route::get('about', [PagesController::class, 'about']) -> name('about');
Route::get('projects/{id?}', [PagesController::class, 'projects'])
    -> where('id', '[0-9]+')
    -> name('projects');
