<?php

namespace App\Http\Controllers;
use App\Models\Libro;

class BooksController extends Controller
{
    public function listBooks()
    {
        $books = Libro::all();
        return view('bookList', @compact('books'));
    }
}
