# Akryl DOM

This library contains functions for building HTML element and styling them with CSS.

# Install

See full project set up in [akryl-core](https://github.com/akryl-kt/akryl-core) repository.

1. Add jcenter repository:

```gradle
repositories {
    jcenter()
    ...
}
```

2. Add dependencies:

```gradle
kotlin {
    sourceSets {
        main {
            dependencies {
                implementation "io.akryl:akryl-dom:0.+"
                implementation npm("react-dom", "16.12.0")
            }
        }
    }
}
```

# Documentation 

## HTML

Instead of JSX, the library uses functions with named arguments. 
To create a Virtual DOM element, call a function like `Div`, `Span` or `Img` and pass HTML attributes as arguments.

```kotlin
// Kotlin
Img(className = "my-image", src = "example.png")
```

```JSX
// JSX
<img className="my-image" src="example.png"/>
```

Use `children`, `child`, and `text` to pass children to an element. 
If an element contains no attributes, pass children as varargs.

```kotlin
// Kotlin
Div(id = "root", children = listOf(
    Header(text = "text"),
    Div(className = "inner", child = Img(src = "example.png")),
    Footer(
        P(text = "first paragraph"),
        P(text = "second paragraph")
    )
))
```

```JSX
// JSX
<div id="root">
    <header>text</header>
    <div className="inner"><img src="example.png"/></div>
    <footer>
        <p>first paragraph</p>
        <p>second paragraph</p>
    </footer>
</div>
```

Use `ReactDom.render` to apply elements or components to document.

```kotlin
fun app() = component {
    Div(text = "Hello, World!")
}

ReactDom.render(app(), document.getElementById("app"))
```

## CSS

The library provides three ways to style elements:

- CSS classes
- Inline CSS
- Inline styles

All CSS happens inside Kotlin, so you don't need to write separate CSS files. 
It provides statically typed styling that leads to fewer errors and better refactoring.

All CSS properties declarations follow this syntax: 

```kotlin
propertyName(singleValue)
propertyName.enumValue()
```

For example:

```kotlin
// single value properties
width(100.px)
paddingLeft(1.em)
content(" ")

// enum properties
display.flex()
overflow.hidden()
flexDirection.column()
border.solid(1.px, Color.red)

// mixed properties
color.red()
color(0xFF0000)

// complex properties
transform
    .translate(100.px, 200.px)
    .scale(1.5)
```

### CSS classes

Use `css` function to create scoped classes. 
These classes will not conflict with each other even if they have identical names on Kotlin side.
It works similar to libraries like [css-modules](https://github.com/css-modules/css-modules).

```kotlin
// Kotlin
val foo by css(
    color.red()
)

val bar by css(
    display.flex(),
    
    hover(
        background.gray()
    ),
    
    foo(
        flex(1, 1, 100.pct)
    )
)
```

```CSS
/* CSS */
.foo {
    color: red;
}

.bar {
    display: flex;
}

.bar:hover {
    background: gray;
}

.bar .foo {
    flex: 1 1 100%;
}
```

### Inline CSS

### Inline styles
