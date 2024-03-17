@extends('plantillaBase')
@section('title', 'Laravel - Añadir libro')
@section('content')
    <section>
        <a href="{{ route('libros.listarLibros') }}" class="btn-goBack">Volver al listado</a>
    </section>
    <section>
        <h2>Añadir nuevo libro</h2>
        <form action="{{ route('libros.formularioInsertar') }}" method="post">
            @csrf
            <article>
                <section class="inputField">
                    <article>
                        <label for="id">ID:</label>
                        <input type="number" name="id" id="id" value="{{ old('id') }}">
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
                        <input type="text" name="titulo" id="titulo" value="{{ old('titulo') }}">
                    </article>
                    @error('titulo')
                    <p class="message error">No olvides rellenar el título.</p>
                    @enderror
                </section>
                <section class="inputField">
                    <article>
                        <label for="genero">Género:</label>
                        <input type="text" name="genero" id="genero" value="{{ old('genero') }}">
                    </article>
                    @error('genero')
                    <p class="message error">No olvides rellenar el género.</p>
                    @enderror
                </section>
                <section class="inputField">
                    <article>
                        <label for="pais">País:</label>
                        <input type="text" name="pais" id="pais" value="{{ old('pais') }}">
                    </article>
                    @error('pais')
                    <p class="message error">No olvides rellenar el país.</p>
                    @enderror
                </section>
                <section class="inputField">
                    <article>
                        <label for="ano">Año de publicación:</label>
                        <input type="number" name="ano" id="ano" value="{{ old('ano') }}">
                    </article>
                    @error('ano')
                    <p class="message error">No olvides rellenar el año de publicación.</p>
                    @enderror
                </section>
                <section class="inputField">
                    <article>
                        <label for="num_paginas">Número de páginas:</label>
                        <input type="number" name="num_paginas" id="num_paginas" value="{{ old('num_paginas') }}">
                    </article>
                    @error('num_paginas')
                    <p class="message error">No olvides rellenar el número de páginas.</p>
                    @enderror
                </section>
                <section>
                    <button type="submit">Añadir libro</button>
                </section>
            </article>
        </form>

        @if(session('mensaje'))
            <p class="message success">{{ session('mensaje') }}</p>
        @endif
    </section>
@endsection
