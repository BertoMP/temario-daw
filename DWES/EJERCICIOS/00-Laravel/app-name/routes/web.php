<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});
Route::get('/about', function () {
    return view('about');
});
Route::get('/contact', function () {
    return view('contact');
})->name('contacto');
Route::view('/datos', 'usuarios');
Route::get('/cliente/{id?}', function ($id = 1) {
    return('Cliente con el id: ' . $id);
})->where('id', '[0-9]+');
Route::view(
    '/datos/{aux?}/{id?}',
    'usuarios',
    ['id' => 5446, 'aux' => 1]
)->where('aux', '[0-9]+');
