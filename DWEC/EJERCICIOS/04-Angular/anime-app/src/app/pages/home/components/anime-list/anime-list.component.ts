import {
  Component,
  Input
} from '@angular/core';
import { AnimeCardComponent } from "./components/anime-card/anime-card.component";
import { AnimeModel } from "../../../../interfaces/anime.model";

@Component({
  selector: 'app-anime-list',
  standalone: true,
  imports: [
    AnimeCardComponent
  ],
  templateUrl: './anime-list.component.html',
  styleUrl: './anime-list.component.css'
})
export class AnimeListComponent {
  @Input() animeList: AnimeModel[] = [];
}
