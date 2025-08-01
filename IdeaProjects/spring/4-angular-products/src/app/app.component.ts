import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Products } from './components/products.component';
import { Product } from './models/product';
import { Form } from "./components/form.component";
import Swal from 'sweetalert2';
import { ProductService } from './services/product.service';

@Component({
  selector: 'app-root',
  imports: [Products, Form],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class App implements OnInit {
  products: Product[] = []
  countId = signal(3)
  productSelected: Product = new Product();

  constructor(private service: ProductService) {}
  ngOnInit(): void {
    this.service.findAll().subscribe(products => this.products = products)
    // this.products = [
    //   {
    //     id: 1,
    //     name: 'Monitor Asus 35 pulgadas',
    //     description: 'El monitor es excelente para juegos de alta resolución',
    //     price: 1000
    //   },
    //   {
    //     id: 2,
    //     name: 'Iphone 16 pro',
    //     description: 'El cel es excelente e incluye Apple Intelligence',
    //     price: 1700
    //   }
    // ]
  }

  addProduct(product: Product) {

    if (product.id > 0) {

      this.service.update(product).subscribe(productUpdated => {
        this.products = this.products.map(prod => {
          if (prod.id == product.id) {
            return productUpdated
          }
          return prod;
        })
        Swal.fire({
          title: "¡Producto Actualizado!",
          text: `¡Producto ${productUpdated.name} actualizado exitosamente!`,
          icon: "success"
        });
      })
    } else {
      this.service.create(product).subscribe(productNew => {
        this.products = [... this.products, { ...productNew}];
        // this.countId.update(id => id + 1);
        Swal.fire({
          title: "¡Producto Creado!",
          text: `¡Producto ${productNew.name} creado exitosamente!`,
          icon: "success"
        });
      })
    }
  }

  onUpdateProductEvent(product: Product): void {
    this.productSelected = { ...product }
  }
  onRemoveProductEvent(id: number): void {

    Swal.fire({
      title: "¿Está seguro de eliminar el producto?",
      text: "Esta acción no se puede revertir",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "¡Si, eliminar!",
      cancelButtonText: "¡No, cancelar!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.remove(id).subscribe(productDeleted => {
          this.products = this.products.filter(product => product.id != id)
          Swal.fire({
            title: "¡Producto Eliminado!",
            text: `¡Producto ${productDeleted.name} eliminado exitosamente!`,
            icon: "success"
          });
        })
      }
    });


  }

}
