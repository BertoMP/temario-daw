@extends('plantillaBase')
@section('title', 'Laravel - Editar libro')
@section('content')
    <section>
        <a href="{{ route('libros.listarLibros') }}" class="btn-goBack">Volver al listado</a>
    </section>
    <section>
        <h2>Editando el libro {{ $libro->ID }}</h2>
        <form action="{{ route('libros.actualizar', $libro->ID) }}" method="POST">
            @method('PUT')
            @csrf
            <article>
                <section class="inputField">
                    <article>
                        <label for="id">ID:</label>
                        <input type="number" name="id" id="id" value="{{ $libro->ID }}">
                    </article>
                    @error('id')
                    <p class="message error">No olvides rellenar el id.</p>
                    @enderror
                    @if(session('idRepetido'))
                        <p class="message error">{{ session('idRepetido') }}</p>
                    @endif
                </section>
                <section class="inputField">
                    <article>
                        <label for="titulo">Título:</label>
                        <input type="text" name="titulo" id="titulo" value="{{ $libro->TITULO }}">
                    </article>
                    @error('titulo')
                    <p class="message error">No olvides rellenar el título.</p>
                    @enderror
                </section>
                <section class="inputField">
                    <article>
                        <label for="genero">Género:</label>
                        <input type="text" name="genero" id="genero" value="{{ $libro->GENERO }}">
                    </article>
                    @error('genero')
                    <p class="message error">No olvides rellenar el género.</p>
                    @enderror
                </section>
                <section class="inputField">
                    <article>
                        <label for="pais">País:</label>
                        <input type="text" name="pais" id="pais" value="{{ $libro->PAIS }}">
                    </article>
                    @error('pais')
                    <p class="message error">No olvides rellenar el país.</p>
                    @enderror
                </section>
                <section class="inputField">
                    <article>
                        <label for="ano">Año de publicación:</label>
                        <input type="number" name="ano" id="ano" value="{{ $libro->ANO }}">
                    </article>
                    @error('ano')
                    <p class="message error">No olvides rellenar el año de publicación.</p>
                    @enderror
                </section>
                <section class="inputField">
                    <article>
                        <label for="num_paginas">Número de páginas:</label>
                        <input type="number" name="num_paginas" id="num_paginas" value="{{ $libro->NUM_PAGINAS }}">
                    </article>
                    @error('num_paginas')
                    <p class="message error">No olvides rellenar el número de páginas.</p>
                    @enderror
                </section>
                <section>
                    <button type="submit">Editar libro</button>
                </section>
            </article>
        </form>
    </section>
@endsection
