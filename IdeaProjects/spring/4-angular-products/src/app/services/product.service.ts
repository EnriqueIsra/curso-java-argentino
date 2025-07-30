import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private url: string = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  findAll(): Observable<Product[]> {
    return this.http.get(this.url).pipe(
      map( (response: any) => response as Product[] )
    )
  }
}
