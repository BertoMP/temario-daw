import {
  Component,
  inject
} from '@angular/core';
import { AnimeService } from "../../services/anime.service";
import { AnimeModel } from "../../interfaces/anime.model";
import { AnimeCardComponent } from "./components/anime-list/components/anime-card/anime-card.component";
import { FormsModule } from "@angular/forms";
import { AnimeListComponent } from "./components/anime-list/anime-list.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    AnimeCardComponent,
    FormsModule,
    AnimeListComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  animeService: AnimeService = inject(AnimeService);
  searchAnime: string = '';
  allAnimes: AnimeModel[] = [];
  animeList: AnimeModel[] = [];

  constructor() {
    this.animeService.getAnimes()
      .then(data => {
        this.allAnimes = data;
        this.allAnimes.sort((a, b) => a.title.localeCompare(b.title));
        this.animeList = this.allAnimes;
      })
      .catch(error => {
        console.error('Error en la recogida de datos:', error);
      });
  }

  onSearchAnime(): void {
    this.animeList = [];
    for (const anime of this.allAnimes) {
      if (anime.title.toLowerCase().startsWith(this.searchAnime.toLowerCase())) {
        this.animeList.push(anime);
      }
    }
  }

  onCleanSearch(): void {
    this.animeList = this.allAnimes;
    this.searchAnime = '';
  }
}
