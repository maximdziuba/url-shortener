function copyToClipboard() {
        var copyText = document.getElementById("shortLink");
        console.log(copyText.value)
        copyText.select();
        copyText.setSelectionRange(0, 99999);
        document.execCommand("copy");
        const el = document.getElementById("text-copied-paragraph");
        el.innerHTML = "Text copied"
}