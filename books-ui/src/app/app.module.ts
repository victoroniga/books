import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BookAddComponent} from './components/book-add/book-add.component';
import {BookListComponent} from './components/book-list/book-list.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {StoreModule} from '@ngrx/store';
import {ReactiveFormsModule} from '@angular/forms';
import {EffectsModule} from '@ngrx/effects';
import {BookEffects} from './effects/book.effects';
import {HttpClientModule} from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import {MatDatepickerModule, MatFormFieldModule, MatInputModule, MatNativeDateModule} from '@angular/material';
import {MomentDateModule} from '@angular/material-moment-adapter';
import {reducers} from './reducers';

@NgModule({
  declarations: [
    AppComponent,
    BookAddComponent,
    BookListComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatButtonModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MomentDateModule,
    StoreModule.forRoot(reducers),
    EffectsModule.forRoot([BookEffects])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
