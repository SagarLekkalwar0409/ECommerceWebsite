import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemofdeleteComponent } from './demofdelete.component';

describe('DemofdeleteComponent', () => {
  let component: DemofdeleteComponent;
  let fixture: ComponentFixture<DemofdeleteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DemofdeleteComponent]
    });
    fixture = TestBed.createComponent(DemofdeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
