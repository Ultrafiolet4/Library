export class BookShow {
  id:number | undefined;
  name:string | undefined;
  year:number | undefined;
  authorName:string | undefined;

  constructor(id?: number, name?: string, year?: number, authorName?: string) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.authorName = authorName;
  }

}
