<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('LIBROS', function (Blueprint $table) {
            $table->integer('ID');
            $table->string('TITULO');
            $table->string('GENERO');
            $table->string('PAIS');
            $table->integer('ANO');
            $table->integer('NUM_PAGINAS');
            $table->timestamps();
            $table->primary('ID');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('libros');
    }
};
