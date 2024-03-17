import { Component, Input } from '@angular/core';
import { AnimeModel } from "../../../../../../interfaces/anime.model";
import {
  MatCard,
  MatCardContent,
  MatCardImage
} from "@angular/material/card";

@Component({
  selector: 'app-anime-card',
  standalone: true,
  imports: [
    MatCard,
    MatCardContent,
    MatCardImage,
  ],
  templateUrl: './anime-card.component.html',
  styleUrls: [
    './anime-card.component.css',
  ]
})
export class AnimeCardComponent {
  @Input() anime!: AnimeModel;
}
