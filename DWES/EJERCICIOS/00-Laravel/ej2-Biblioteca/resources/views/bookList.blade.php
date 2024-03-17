<h1>Libros de la base de datos</h1>
<table border="1">
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
        @foreach($books as $book)
        <tr>
            <td>{{$book->ID_LIBRO}}</td>
            <td>{{$book->TITULO}}</td>
            <td>{{$book->GENERO}}</td>
            <td>{{$book->PAIS}}</td>
            <td>{{$book->ANO}}</td>
            <td>{{$book->NUM_PAGINAS}}</td>
        </tr>
        @endforeach
    </tbody>
</table>
