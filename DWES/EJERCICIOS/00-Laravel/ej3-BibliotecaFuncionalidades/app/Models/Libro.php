<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Libro extends Model
{
    use HasFactory;
    protected $table = 'LIBROS';
    protected $primaryKey = 'ID';
    protected $fillable = [
        'TITULO',
        'GENERO',
        'PAIS',
        'ANO',
        'NUM_PAGINAS',
        'created_at',
        'updated_at'
    ];
}
