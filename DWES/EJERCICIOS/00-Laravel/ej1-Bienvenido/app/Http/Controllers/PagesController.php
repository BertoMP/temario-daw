<?php

namespace App\Http\Controllers;

class PagesController extends Controller
{
    public function home()
    {
        return view('home');
    }

    public function about()
    {
        $equipo = ['Paco', 'Enrique', 'Maria', 'Veronica' ];
        return view('about', @compact('equipo'));
    }

    public function projects($id = null)
    {
        return view('projects', ['id' => $id]);
    }
}
