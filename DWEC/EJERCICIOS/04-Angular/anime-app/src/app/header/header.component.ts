import { Component } from '@angular/core';
import { MusicPlayerComponent } from "./components/music-player/music-player.component";
import { LogoComponent } from "./components/logo/logo.component";

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    MusicPlayerComponent,
    LogoComponent
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
}
