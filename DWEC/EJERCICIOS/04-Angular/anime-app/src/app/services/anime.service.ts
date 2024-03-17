import { Injectable } from '@angular/core';
import { AnimeModel } from "../interfaces/anime.model";

@Injectable({
  providedIn: 'root'
})
export class AnimeService {
  url: string = 'http://localhost:3000/results';

  constructor() { }

  getAnimes(): Promise<AnimeModel[]> {
    return new Promise((resolve, reject) => {
      fetch(this.url)
        .then(response => response.json())
        .then(data => {
          resolve(data);
        })
        .catch(error => {
          reject(error);
        });
    });
  }
}
