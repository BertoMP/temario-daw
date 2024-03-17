<?php

use \App\Http\Controllers\ControladorLibros;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('libros', [ControladorLibros::class, 'listarLibros'])
    ->name('libros.listarLibros');
Route::get('libros/{id}', [ControladorLibros::class, 'buscaLibro'])
    ->where('id', '[0-9]+')
    ->name('libros.id');
Route::get('insertarLibro', [ControladorLibros::class, 'formularioInsertar'])
    ->name('libros.formularioInsertar');

Route::post('insertarLibro', [ControladorLibros::class, 'crearLibro'])
    ->name('libros.crearLibro');
Route::post('buscarLibro', [ControladorLibros::class, 'formularioBusqueda'])
    ->name('libros.id');

Route::get('editarLibro/{id}', [ControladorLibros::class, 'editar'])
    ->where('id', '[0-9]+')
    ->name('libros.editar');
Route::put('actualizarLibro/{id}', [ControladorLibros::class, 'actualizar'])
    ->where('id', '[0-9]+')
    ->name('libros.actualizar');

Route::get('eliminarLibro/{id}', [ControladorLibros::class, 'eliminar'])
    ->where('id', '[0-9]+')
    ->name('libros.eliminar');
