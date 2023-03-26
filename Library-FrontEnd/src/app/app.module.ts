import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { FormsModule } from '@angular/forms';
import {RouterModule, RouterOutlet, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";

const routes: Routes = [
  {path: 'books', component: BookListComponent},
  {path: 'create-book', component: CreateBookComponent},
  {path: '', redirectTo: 'books', pathMatch: 'full'},
  {path: 'update-book/:id', component: UpdateBookComponent},
  {path: 'book-details/:id', component: BookDetailsComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    CreateBookComponent,
    UpdateBookComponent,
    BookListComponent,
    BookDetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterOutlet,
    RouterModule.forRoot(routes, { useHash: true }),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
