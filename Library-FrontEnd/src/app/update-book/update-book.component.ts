import {Component, OnInit} from '@angular/core';
import {BookCreating} from "../bookCreating";
import {BookService} from "../book.service";
import {ActivatedRoute, Router} from "@angular/router";
import {BookShow} from "../book";

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {
  id: number;
  book: BookCreating = new BookCreating();
  bookForShow:BookShow = new BookShow();
  constructor(private bookService: BookService,
              private route: ActivatedRoute,
              private router: Router) {
    this.id = 0;
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.bookService.getBookById(this.id).subscribe(data => {
      this.bookForShow = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.bookService.updateBook(this.id, this.book).subscribe( data =>{
        this.goToEmployeeList();
      }
      , error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/books']).then(nav => {
      console.log(nav);
    }, err => {
      console.log(err)
    });
  }
}
