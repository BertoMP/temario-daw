@extends('plantillaBase')
@section('title', 'Laravel - Listado libros')
@section('content')
    <section>
        <h2>Libros disponibles en la base de datos</h2>
        {{ $libros->links() }}
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>TÍTULO</th>
                <th>GÉNERO</th>
                <th>PAIS</th>
                <th>AÑO PUBLICACIÓN</th>
                <th>NÚMERO DE PÁGINAS</th>
                <th colspan="2">ACCIONES</th>
            </tr>
            </thead>
            <tbody>
            @foreach($libros as $libro)
                <tr>
                    <td>{{$libro->ID}}</td>
                    <td>{{$libro->TITULO}}</td>
                    <td>{{$libro->GENERO}}</td>
                    <td>{{$libro->PAIS}}</td>
                    <td>{{$libro->ANO}}</td>
                    <td>{{$libro->NUM_PAGINAS}}</td>
                    <td>
                        <a href="{{ route('libros.editar', $libro->ID) }}" class="btn-editBook">Editar</a>
                    </td>
                    <td>
                        <a href="{{ route('libros.eliminar', $libro->ID) }}" class="btn-deleteBook">Eliminar</a>
                    </td>
                </tr>
            @endforeach
            </tbody>
        </table>
    </section>
        @if(session('mensaje'))
            <section>
                <p class="message success">{{ session('mensaje') }}</p>
            </section>
        @endif
        @if(session('libroEliminado'))
            <section>
                <p class="message error">{{ session('libroEliminado') }}</p>
            </section>
        @endif
        @if(session('libroActualizado'))
            <section>
                <p class="message success">{{ session('libroActualizado') }}</p>
            </section>
        @endif

    <section>
        <a href="{{ route('libros.formularioInsertar') }}" class="btn-addBook">Añadir nuevo libro</a>
    </section>

    <section>
        <h2>Búsqueda</h2>
        <form action="{{ route('libros.id') }}" method="post" class="searchForm">
            @csrf
            <article>
                <label for="idLibro">ID libro</label>
                <input type="number" name="idLibro" id="idLibro">
                <button type="submit">Buscar</button>
                @error('idLibro')
                <p class="message error">No olvides rellenar el id.</p>
                @enderror
            </article>
        </form>
    </section>
@endsection
