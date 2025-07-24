import { Component, Input } from '@angular/core';
import { Product } from '../models/product';

@Component({
  selector: 'table-products',
  imports: [],
  templateUrl: './products.html'
})
export class Products {
  @Input() products: Product[] = []
  title = 'Listado de productos'
}
