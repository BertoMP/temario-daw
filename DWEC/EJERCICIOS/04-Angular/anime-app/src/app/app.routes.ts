import { Routes } from '@angular/router';
import { HomeComponent } from "./pages/home/home.component";
import {FilmsComponent} from "./pages/films/films.component";

export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'My Animes - Listado animes'
  },
  {
    path: 'films',
    component: FilmsComponent,
    title: 'My Animes - Listado películas'
  },
];
