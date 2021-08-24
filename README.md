# Andriod Application Development

## Manifest

### AndroidManifest.xml

**Folder:** `app/manifest/`

This File Involves the Following;

- Application Icon/Icons
- Application Label/Labels
- Application Themes
- Application Meta Data
- Application Permissions
- Application Activities


## Activities

**Folder:** `app/java/com.example.application/MainActivity`

Every Screen View is said to be an Activity in Android App Development

### Methods / Classed

- findViewById()
- R
	- R.id.{}
	- r.color.{}
- InputMethodManager ( to hide keypad after usage )
```java
InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
```

### Activity LifeCycles

- onCreate()
- onStart()
- onResume()
- onPause()
- onRestart()
- onStop()


## Resources

**Folder:** `app/res/`

- Drawables
- Layout
- MipMap
- Values
	- Colors
	- Strings
	- Styles
	- Dimensions
	- Themes
		- Themes
		- Themes ( night )

## Views

### Layouts

- Linear Layout
- Constraint Layout
- Scroll View Layout

### Heirarchy

- View
	- TextView
		- Button
		- Edit Text
	- ImageView
	- ViewGroup
		- Linear Layout
		- Contraint Layout
		- Frame Layout
			- Scroll View

## Binding

### View Binding

```java
buildFeatures {
    dataBinding true
}
```

**Note:** Sync after adding the Code

```java
android {
    compileSdk 31

    defaultConfig {
        applicationId "com.example.mydroid2"
        minSdk 22
        targetSdk 31
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    buildFeatures {
        dataBinding true
    }
}
```

Then, change the Activity Layout as Well

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".MainActivity">
    <androidx.appcompat.widget.LinearLayoutCompat
        android:layout_width="match_parent"
        android:background="@color/teal_700"
        android:orientation="vertical"
        android:layout_height="match_parent">
    </androidx.appcompat.widget.LinearLayoutCompat>
</layout>
```

Then, Use Binding inside the Activity

```java
private ActivityMainBinding binding;
```

```java
binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

binding.hobbyButton.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view) {
        addHobby(view);
    }
});
```

```java
String data = binding.hobbyInput.getText().toString();
binding.hobbyInput.setText("");
binding.hobbyResult.setText("Hobbies: "+data.toString());
binding.invalidateAll();
binding.hobbyResult.setVisibility(View.VISIBLE);
```

Using Lambda

```java
binding.hobbyButton.setOnClickListener(this::addHobby);
```

Then, remove Event Listeners from the Activity XML File

### Data Binding

Create a Package with the Main Activity and Create a Class in a Data Folder

Then, add Data Variables in the XML

```xml
<data>
    <variable name="bio" type="com.example.mydroid2.data.Bio" />
</data>
```

Connect View Tags wit the Data

```xml
 <TextView
    android:id="@+id/textView"
    style="@style/main_title_style"
    android:text="@{bio.name}" />
```

Create the Class Instance in the Activity

```java
private final Bio bio = new Bio();
```

Then, Bind the Data 

```java
 bio.setName("Zaeem");
 binding.setBio(bio);
```

Then, Change Usage Formation

```java
 bio.setHobbies("Hobbies: "+binding.hobbyInput.getText().toString());
 binding.hobbyInput.setText("");
 binding.invalidateAll();
 binding.hobbyResult.setVisibility(View.VISIBLE);
```