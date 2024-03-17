export interface AnimeModel {
  id: number;
  hiraganaTitle: string;
  title: string;
  genres: string[];
  episodes: number;
  releaseDate: Date;
  studio: string;
  isOnAir: boolean;
  imageUrl: string;
  description: string;
}
