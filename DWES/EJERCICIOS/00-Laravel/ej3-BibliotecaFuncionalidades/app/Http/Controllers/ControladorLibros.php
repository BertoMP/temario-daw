<?php

namespace App\Http\Controllers;

use App\Models\Libro;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Session;
use Illuminate\Support\Facades\Validator;

class ControladorLibros extends Controller
{
    public function listarLibros()
    {
        $libros = Libro::paginate(5);
        return view('listadoLibros', @compact('libros'));
    }

    public function buscaLibro($ID_LIBRO)
    {
        $libro = Libro::findOrFail($ID_LIBRO);
        return view('libros.id', @compact('libro'));
    }

    public function formularioInsertar() {
        return view('libros.formularioInsertar');
    }

    public function crearLibro(Request $request) {
        $validator = Validator::make($request->all(), [
            'id' => 'required',
            'titulo' => 'required',
            'genero' => 'required',
            'pais' => 'required',
            'ano' => 'required',
            'num_paginas' => 'required',
        ]);

        if ($validator->fails()) {
            return back()
                ->withErrors($validator)
                ->withInput();
        }

        if (Libro::find($request->id)) {
            return back()
                ->with('idRepetido', 'El id ya está en uso.')
                ->withInput();
        }

        $libro = new Libro();
        $libro->ID = $request->id;
        $libro->TITULO = $request->titulo;
        $libro->GENERO = $request->genero;
        $libro->PAIS = $request->pais;
        $libro->ANO = $request->ano;
        $libro->NUM_PAGINAS = $request->num_paginas;
        $libro->save();
        return back()
            ->with('mensaje', 'Libro añadido correctamente.')
            ->withInput();
    }

    public function formularioBusqueda(Request $request)
    {
        $request -> validate([
            'idLibro' => 'required'
        ]);

        $libro = Libro::findOrFail($request->idLibro);
        return view('libros.id', compact('libro'));
    }

    public function editar($ID_LIBRO)
    {
        $libro = Libro::findOrFail($ID_LIBRO);
        return view('libros.editar', compact('libro'));
    }

    public function actualizar(Request $request, $ID_LIBRO)
    {
        $validator = Validator::make($request->all(), [
            'titulo' => 'required',
            'genero' => 'required',
            'pais' => 'required',
            'ano' => 'required',
            'num_paginas' => 'required',
        ]);

        if ($validator->fails()) {
            return redirect()->back()
                ->withErrors($validator)
                ->withInput();
        }

        $libroActualizar = Libro::findOrFail($ID_LIBRO);
        $libroActualizar->TITULO = $request->titulo;
        $libroActualizar->GENERO = $request->genero;
        $libroActualizar->PAIS = $request->pais;
        $libroActualizar->ANO = $request->ano;
        $libroActualizar->NUM_PAGINAS = $request->num_paginas;
        $libroActualizar->save();
        Session::flash('libroActualizado', 'Libro con ID ' . $ID_LIBRO . ' actualizado correctamente.');
        return redirect()->route('libros.listarLibros');
    }

    public function eliminar($ID_LIBRO)
    {
        $libro = Libro::findOrFail($ID_LIBRO);
        $libro->delete();
        return back()->with('libroEliminado', 'Libro con ID ' . $libro->ID . ' correctamente.');
    }
}
