import {
  Component,
  ElementRef,
  inject,
  ViewChild
} from '@angular/core';
import { FormsModule } from "@angular/forms";
import { SongModel } from "../../../interfaces/song.model";
import { SongService } from "../../../services/song.service";
import { CommonModule } from "@angular/common";

@Component({
  selector: 'app-music-player',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './music-player.component.html',
  styleUrls: ['./music-player.component.css']
})
export class MusicPlayerComponent {
  @ViewChild('audioPlayer') audioPlayer: ElementRef<HTMLAudioElement> | undefined;
  @ViewChild('progressElement') progressBar: ElementRef<HTMLProgressElement> | undefined;

  songServive: SongService = inject(SongService);
  actualSong: SongModel = {} as SongModel;

  songs: SongModel[] = this.songServive.getSongs();

  isPause: boolean = false;
  isStop: boolean = true;

  baseUrl: string = '/assets/audio/';
  songUrl: string = '';
  currentSongIndex: number = 0;
  volumen: number = 100;
  currentTime: number = 0;
  duration: number = 0;
  currentTimePercentage: number = 0;

  constructor() {
    this.currentSongIndex = Math.floor(Math.random() * this.songs.length);
    this.actualSong = this.songs[this.currentSongIndex];
    this.duration = 0;
  }

  onPlay(): void {
    if (this.audioPlayer) {
      this.isStop = false;
      this.songUrl = `${this.baseUrl}${this.actualSong.url}`;

      if (this.isPause) {
        this.audioPlayer.nativeElement.play();
        this.isPause = false;
        return;
      }

      this.duration = this.audioPlayer.nativeElement.duration;
    }
  }

  onPause(): void {
    if (this.audioPlayer) {
      this.isStop = false;
      this.isPause = true;
      this.audioPlayer.nativeElement.pause();
    }
  }

  onStop(): void {
    if (this.audioPlayer) {
      this.currentTime = 0;
      this.currentTimePercentage = 0;
      this.isStop = true;
      this.audioPlayer.nativeElement.pause();
    }
  }

  onNext(): void {
    if (this.audioPlayer) {
      this.currentSongIndex = this.currentSongIndex + 1;

      if (this.currentSongIndex >= this.songs.length) {
        this.currentSongIndex = 0;
      }

      this.actualSong = this.songs[this.currentSongIndex]
      this.currentTime = 0;
      this.currentTimePercentage = 0;

      if (!this.isStop && !this.isPause) {
        this.onPlay();
      }
    }
  }

  onPrev(): void {
    this.currentSongIndex = this.currentSongIndex - 1;

    if (this.currentSongIndex < 0) {
      this.currentSongIndex = this.songs.length - 1;
    }

    this.actualSong = this.songs[this.currentSongIndex];
    this.currentTime = 0;
    this.currentTimePercentage = 0;

    if (!this.isStop && !this.isPause) {
      this.onPlay();
    }
  }

  onSetVolume(): void {
    if (this.audioPlayer) {
      this.audioPlayer.nativeElement.volume = this.volumen / 100;
    }
  }

  onTimeUpdate(): void {
    if (this.audioPlayer) {
      this.currentTime = this.audioPlayer.nativeElement.currentTime;
      this.duration = this.audioPlayer.nativeElement.duration;

      this.currentTimePercentage = (this.currentTime / this.duration) * 100;
    }
  }

  onProgressBarClick(event: MouseEvent): void {
    if (this.progressBar && this.audioPlayer) {
      const clickPosition: number = event.clientX - this.progressBar.nativeElement.getBoundingClientRect().left;
      const percentageClicked: number = (clickPosition / this.progressBar.nativeElement.clientWidth) * 100;

      this.audioPlayer.nativeElement.currentTime = (percentageClicked / 100) * this.duration;
    }
  }

  formatTime(time: number): string {
    const minutes: number = Math.floor(time / 60);
    const seconds: number = Math.floor(time % 60);
    return `${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
  }

  protected readonly isFinite = isFinite;
}
