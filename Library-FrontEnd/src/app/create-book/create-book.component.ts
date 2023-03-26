import {Component, OnInit} from '@angular/core';
import {BookCreating} from "../bookCreating";
import {BookService} from "../book.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {
  book:BookCreating = new BookCreating();
  constructor(private bookService: BookService,
              private router: Router) {
  }

  ngOnInit(): void {

  }

  saveBook() {
    this.bookService.createBook(this.book).subscribe(data => {
      console.log(data);
      this.goToBookList();
    },
      error => console.log(error));
  }

  goToBookList() {
    this.router.navigate(['/books']).then(nav => {
      console.log(nav);
    }, err => {
      console.log(err)
    });
  }

  onSubmit() {
    console.log(this.book);
    this.saveBook();
  }
}
