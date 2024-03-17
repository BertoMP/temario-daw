import { Injectable } from '@angular/core';
import { SongModel } from "../interfaces/song.model";

@Injectable({
  providedIn: 'root'
})
export class SongService {
  songs: SongModel[] = [
    {
      name: 'CHA-LA HEAD CHA-LA',
      hiraganaTitle: 'ちゃら・へっど・ちゃら',
      anime: 'Dragon Ball Z',
      url: 'dbz.mp3',
      img: 'dragon-ball-z.webp',
    },
    {
      name: 'MAKAFUSHIGI ADVENTURE',
      hiraganaTitle: 'まかふしぎ・アドベンチャー',
      anime: 'Dragon Ball',
      url: 'db.mp3',
      img: 'dragon-ball.webp'
    },
    {
      name: 'HIKARU NARA',
      hiraganaTitle: 'ひかる・なら',
      anime: 'Your Lie in April',
      url: 'your-lie.mp3',
      img: 'your-lie-in-april.webp'
    },
    {
      name: 'WE ARE!',
      hiraganaTitle: 'うぃ・あー',
      anime: 'One Piece',
      url: 'op.mp3',
      img: 'one-piece.webp'
    },
    {
      name: 'Tank!',
      hiraganaTitle: 'たんく',
      anime: 'Cowboy Bebop',
      url: 'cb.mp3',
      img: 'cowboy-bebop.webp'
    },
    {
      name: 'The World',
      hiraganaTitle: 'ざ・わーるど',
      anime: 'Death Note',
      url: 'dn.mp3',
      img: 'death-note.webp'
    },
    {
      name: 'Guren no Yumiya',
      hiraganaTitle: 'ぐれん・の・ゆみや',
      anime: 'Shingeki no Kyojin',
      url: 'snk.mp3',
      img: 'shingeki-no-kyojin.webp'
    },
    {
      name: 'Gurenge',
      hiraganaTitle: 'ぐれんげ',
      anime: 'Kimetsu no Yaiba',
      url: 'kny.mp3',
      img: 'kimetsu-no-yaiba.webp'
    }
  ]

  constructor() { }

  getSongs(): SongModel[]{
    return this.songs;
  }
}
