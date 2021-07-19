let addForm = document.addfrm
let text = addForm.add
let ul = document.querySelector('.todos')
let spn = document.createElement('span')

addForm.addEventListener('submit', (e) => {
  e.preventDefault() //cancelling default brhaviour of browser
  let newItem = text.value //taking value from input box to add to li
  //console.log(newItem);
  if (newItem.length > 0) {
    addItems(newItem)
    text.value = '' //clearing the text box after adding li
    spn.remove() //deleting new list
    text.style.outline = 'none' //replacing the border of input box
    text.style.border = 'green'
  } else {
    addForm.appendChild(spn)
    spn.innerHTML = 'Please input first!'
    spn.style.color = 'red'
    text.style.outline = 'none'
    text.style.border = '1px solid red'
  }
})

let addItems = (newItem) => {
  let str = `<li class="list-group-item d-flex justify-content-between align-items-center">
  <span>${newItem}</span>
  <i class="far fa-trash-alt delete"></i>
</li>`
  ul.innerHTML += str
}

ul.addEventListener('click', function (e) {
  if (e.target.nodeName === 'I') {
    // let choice = confirm("Are you sure ?");
    // if (choice)
    e.target.parentElement.remove()
    //else
    e.preventDefault()
  }
})

let searchList = (text) => {
  let listItems = ul.children
  for (let li of listItems) {
    if (li.innerText.toLowerCase().indexOf(text) == -1) {
      li.classList.add('filtered')
    } else {
      li.classList.remove('filtered')
    }
  }
}

let searchAllList = document.querySelector('.search input')
searchAllList.addEventListener('keyup', (e) => {
  let text = searchAllList.value
  if (text.length < 0) {
    searchSpan.innerHTML = 'Please input first!'
    searchSpan.style.color = 'red'
    searchSpan.style.outline = 'none'
    searchSpan.style.border = '1px solid red'
  }
  searchList(text.toLowerCase().trim())
})
