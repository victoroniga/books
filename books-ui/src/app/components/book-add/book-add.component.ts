import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Book} from '../../entities/book';
import {BookActionType} from '../../actions/book-action';
import {AppState} from '../../reducers';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material';
import {MomentDateAdapter} from '@angular/material-moment-adapter';

import * as _moment from 'moment';
import {defaultFormat as _rollupMoment} from 'moment';
const moment = _rollupMoment || _moment;

export const MY_FORMATS = {
  parse: {
    dateInput: 'YYYY-MM-DDD',
  },
  display: {
    dateInput: 'YYYY-MM-DD',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};

@Component({
  selector: 'app-book-add',
  templateUrl: './book-add.component.html',
  styleUrls: ['./book-add.component.css'],
  providers: [
    {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    {provide: MAT_DATE_FORMATS, useValue: MY_FORMATS},
  ]
})
export class BookAddComponent implements OnInit {

  formGroup: FormGroup;
  maxDate = new Date();

  constructor(private store: Store<AppState>, private formBuilder: FormBuilder) {
    this.createForm();
  }

  createForm() {
    this.formGroup = this.formBuilder.group({
      author: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(255)])],
      title: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(255)])],
      published: ['', Validators.required],
      notes: [''],
    });
  }

  ngOnInit() {
  }

  addBook(author, title, published, notes) {
    this.store.dispatch({
      type: BookActionType.Add,
      payload: <Book>{
        id: null,
        author: author,
        title: title,
        published: published,
        notes: notes
      }
    });
  }
}
