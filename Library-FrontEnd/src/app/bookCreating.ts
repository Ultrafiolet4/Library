export class BookCreating {
  name:string | undefined;
  year:number | undefined;
  authorId:number | undefined;
  constructor(name?: string, year?: number, authorId?: number) {
  this.name = name;
  this.year = year;
  this.authorId = authorId;
}

}
