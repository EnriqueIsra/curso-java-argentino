import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Products } from './components/products';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Products],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal ('Hola Mundo Angular');
}
