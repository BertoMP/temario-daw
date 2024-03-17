@extends('plantillaBase')
@section('title', 'Laravel - Búsqueda de un libro')
@section('content')
    <section>
        <a href="{{ route('libros.listarLibros') }}" class="btn-goBack">Volver al listado</a>
        <h2>Resultado de la búsqueda</h2>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>TÍTULO</th>
                <th>GÉNERO</th>
                <th>PAÍS</th>
                <th>AÑO PUBLICACIÓN</th>
                <th>NÚMERO DE PÁGINAS</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{ $libro->ID }}</td>
                <td>{{ $libro->TITULO }}</td>
                <td>{{ $libro->GENERO }}</td>
                <td>{{ $libro->PAIS }}</td>
                <td>{{ $libro->ANO }}</td>
                <td>{{ $libro->NUM_PAGINAS }}</td>
            </tr>
            </tbody>
        </table>
    </section>
@endsection
