import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Products } from './components/products';
import { Product } from './models/product';

@Component({
  selector: 'app-root',
  imports: [Products],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  products: Product[] = []

  ngOnInit(): void {
    this.products = [
      {
        id: 1,
        name: 'Monitor Asus 35 pulgadas',
        description: 'El monitor es excelente para juegos de alta resolución',
        price: 1000
      },
      {
        id: 2,
        name: 'Iphone 16 pro',
        description: 'El cel es excelente e incluye Apple Intelligence',
        price: 1700
      }
    ]
  }

}
