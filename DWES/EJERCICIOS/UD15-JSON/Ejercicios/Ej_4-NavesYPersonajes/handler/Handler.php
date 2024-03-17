<?php
class Handler
{
    private string $strController;
    private string $strAction;
    private array $arrParams;

    public function __construct()
    {
        $this->strController = '';
        $this->strAction = '';
        $this->arrParams = [];
        $this->fillAttributes();
    }

    private function fillAttributes(): void
    {
        $strURI = 'http://' . $_SERVER['SERVER_NAME'] . $_SERVER['REQUEST_URI'];

        $arrParseURL = parse_url($strURI);

        if (is_array($arrParseURL) && str_contains($strURI, 'index.php')) {
            $arrStrUri = explode('index.php', $strURI);

            $arrAttributes = explode('/', $arrStrUri[1]);

            $this->strController = $arrAttributes[1] ?? '';
            $this->strAction = $arrAttributes[2] ?? '';
            $this->arrParams = array_slice($arrAttributes, 3);
        }
    }

    public function getController(): string
    {
        return $this->strController;
    }

    public function getAction(): string
    {
        return $this->strAction;
    }

    public function getParams(): array
    {
        return $this->arrParams;
    }
}