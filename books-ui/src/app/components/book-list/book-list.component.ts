import {Component, OnInit} from '@angular/core';
import {Book} from '../../entities/book';
import {Store} from '@ngrx/store';
import {AppState} from '../../reducers';
import {BookActionType} from '../../actions/book-action';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  displayedColumns: string[] = ['author', 'title', 'published', 'notes'];
  dataSource = new MatTableDataSource<Book>();

  constructor(private store: Store<AppState>) {
    this.store.dispatch({
      type: BookActionType.Load,
    });

    this.store.select(state => state.books).subscribe((books: Book[]) => {
      this.dataSource.data = books;
    });
  }

  ngOnInit() {
  }
}
