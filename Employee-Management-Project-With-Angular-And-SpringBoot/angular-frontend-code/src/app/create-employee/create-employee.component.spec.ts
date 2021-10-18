import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { CreateEmployeeComponent } from './create-employee.component';
import { DebugElement } from "@angular/core";
import { By } from "@angular/platform-browser";


describe('CreateEmployeeComponent', () => {
  let component: CreateEmployeeComponent;
  let fixture: ComponentFixture<CreateEmployeeComponent>;
  let firstName: DebugElement;
  let lastName: DebugElement;
  let emailId: DebugElement;
  let submit: DebugElement;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CreateEmployeeComponent]
    });

    fixture = TestBed.createComponent(CreateEmployeeComponent);
    component = fixture.componentInstance;

    submit = fixture.debugElement.query(By.css('input[id=submit]'));
    firstName = fixture.debugElement.query(By.css('input[id=firstname]'));
    lastName = fixture.debugElement.query(By.css('input[id=lastname]'));
    emailId = fixture.debugElement.query(By.css('input[type=emailId]'));
  }));

  it('Setting value to input properties on form load', () => {
    fixture.detectChanges();
    expect(submit.nativeElement.disabled).toBeTruthy();
  });

  it('Setting value to input properties on button click', () => {
    fixture.detectChanges();
    expect(submit.nativeElement.disabled).toBeFalsy();
  });

  it('Entering value in input controls and emit output events', () => {
    let user: any;
    firstName.nativeElement.value = "";
    lastName.nativeElement.value = "";
    emailId.nativeElement.value = "@gmail.com";
    submit.triggerEventHandler('click', null);
    expect(user.firstName).toBe("");
    expect(user.lastName).toBe("");
    expect(user.email).toBe("@gmail.com");
  });
});
