@extends('main')
@section('content')
    <h2>Estás en la sección Nosotros</h2>
    <?php
        $equipo = ['María', 'Alfredo', 'William', 'Verónica'];
    ?>
    @foreach($equipo as $nombre)
        <p>{{ $nombre }}</p>
    @endforeach
@endsection
